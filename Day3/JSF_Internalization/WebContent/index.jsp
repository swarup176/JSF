<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
	<html>    
		<body>
			<h:form>
				<h:outputText value="#{message['my.text']}" />
								
				<h:panelGrid columns="2">
					
					Select Language
					<h:selectOneMenu value="#{language.locale}" onchange="submit()"
						valueChangeListener="#{language.localeChanged}">
						<f:selectItems value="#{language.countries}" /> 
					</h:selectOneMenu>

				</h:panelGrid>
			</h:form>
		</body>
	</html>
</f:view>