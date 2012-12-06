<h4><g:message code="issues.list.title"/></h4>
<ul>
	<g:each var="currentIssue" in="${allIssues}">
		<li>
			<a href="${currentIssue.url}">${currentIssue.title}</a> (${currentIssue.state})
		</li>
	</g:each>
</ul>