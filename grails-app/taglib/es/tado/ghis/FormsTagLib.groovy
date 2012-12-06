package es.tado.ghis

class FormsTagLib {

	static namespace = 'forms'
	
	def renderInput = { attrs ->
		out <<
			"<label for='${attrs.name}'>" <<
			g.message(code:"forms.input.${attrs.name}") <<
			"</label>" <<
			g."${attrs.inputType}"(attrs)
	}
	
	def renderInputs = { attrs ->
		attrs.inputProps.each { currentInputProps ->
			out << renderInput(currentInputProps)
		}
	}
	
}
