package com.tado.ghis

class IssueController 
{
	def githubService

    def submitNewIssue(final String title, final String description)
	{
		log.debug "Received new issue with title $title and description $description"
		githubService.createNewIssue(title, description)
		redirect controller:'home'
	}
	
}
