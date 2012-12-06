<div id="create-issue">

	<a href="#issueFormContainer" role="button" class="btn" data-toggle="modal">
		<g:message code="submit.new.issue" />
	</a>

	<div id="issueFormContainer" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="issueFormContainerLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="issueFormContainerLabel">
				<g:message code="submit.new.issue.title" />
			</h3>
			<p><g:message code="submit.new.issue.description" /></p>
		</div>
		<g:form method="POST" controller="issue" action="submitNewIssue">
			<div class="modal-body">
				<forms:renderInputs inputProps="${[
					[name:'title', inputType:'textField'],
					[name:'description', inputType:'textArea']
				]}" />
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">
					<g:message code="forms.close"/>
				</button>
				<button class="btn btn-primary">
					<g:message code="forms.submit"/>
				</button>
			</div>
		</g:form>
	</div>
</div>
