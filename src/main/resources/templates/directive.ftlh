<#ftlh>
<html>
<head>
<title>Welcome!</title>
</head>
<body>
<div><p>Demo for Repeat Directive</p>
<#assign x = 1>

<@repeat count=4>
  Test ${x}
  <#assign x=x+1>
</@repeat>

<@repeat count=3 hr=true>
  Test
</@repeat>

<@repeat count=3; cnt>
  ${cnt}. Test
</@repeat>
</div>

<div><p>Demo for Upper Directive</p>
foo
<@upper>
  bar
  <#-- All kind of FTL is allowed here -->
  <#list ["red", "green", "blue"] as color>
    ${color}
  </#list>
  baaz
</@upper>
wombat
</div>
</body>
</html>
