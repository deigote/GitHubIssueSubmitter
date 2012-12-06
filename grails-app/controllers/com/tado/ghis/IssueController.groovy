package com.tado.ghis

class IssueController {

    def submitNewIssue(final String title, final String description)
	{
		println "Received new issue with title $title and description $description"
		render "Yay"
	}
}
