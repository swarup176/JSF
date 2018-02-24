<%@ taglib uri="/WEB-INF/CustomBody.tld" prefix="cb" %>

<html>
  <head>
    <title>A custom tag: body content</title>
  </head>
  <body>
    This page uses a custom tag manipulates its body content.
    Here is its output:
    <ol>
      <cb:CustomBodyContentTag howMany="3">
        <li>Test CustomBody</li>
      </cb:CustomBodyContentTag>
    </ol>
  </body>
</html>

