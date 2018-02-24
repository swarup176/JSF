<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:loadBundle basename="com.cts.messages" var="msgs" />
   <f:view>
      <head> 
         <title><h:outputText value="#{msgs.title}"/></title>
      </head>
      <body>
         <h:form>
            <p>
               <h:outputText value="#{quiz.question}"/>
            </p>
            <p>
               <h:inputText value="#{quiz.response}"/>
            </p>
            <p>
               <h:commandButton value="#{msgs.answerButton}" 
                  action="#{quiz.answerAction}"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>
