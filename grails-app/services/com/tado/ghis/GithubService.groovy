package com.tado.ghis

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.POST
import groovyx.net.http.HTTPBuilder
import org.apache.http.protocol.*
import org.apache.http.auth.*
import org.apache.http.*
import groovyx.net.http.RESTClient

class GithubService {

	static transactional = false	
	def grailsApplication

    def createNewIssue(title, description)
	{
		doPostRequest(
			grailsApplication.config.github.api.submitIssue.path, 
			[title: title, body: description]
		)
	}
	
	def getAllIssues()
	{
		doGetRequest(
			grailsApplication.config.github.api.getAllIssues.path
		)
	}
	
	def getAllRepos()
	{
		doGetRequest(
			grailsApplication.config.github.api.getAllRepos.path
		)
	}
	
	private doPostRequest(path, data = [:])
	{
		restClient.post(path:path, body:data).data
	}
	
	private doGetRequest(path) 
	{
		restClient.get(path:path).data
	}
	
	private getRestClient()
	{
		new RESTClient(grailsApplication.config.github.api.url).with {
			contentType = JSON
			handler.failure = { resp ->
				throw new RuntimeException("Got an error while connection to GitHub with the URL $path: ${resp.statusLine}")
			}
			client.addResponseInterceptor(
				[process: { HttpResponse response, HttpContext context ->
					response.removeHeaders('Set-Cookie') // httpclient can't parse this, so remove it
				}] as HttpResponseInterceptor,
				0
			)
			client.addRequestInterceptor(
				[process: { HttpRequest request, HttpContext context ->
					request.setHeader("Authorization", "Basic $basicAuth")
				}] as HttpRequestInterceptor
			)
			delegate
		}
	}	
	
	private getBasicAuth(username = grailsApplication.config.github.user,
			password = grailsApplication.config.github.password)
	{
		"$username:$password".toString().bytes.encodeBase64()
	}
	
}
