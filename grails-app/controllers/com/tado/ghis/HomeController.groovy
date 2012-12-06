package com.tado.ghis

class HomeController {

	def githubService
	
    def index() { 
		render view: '/index', model:[allIssues: githubService.allIssues] 
	}
}
