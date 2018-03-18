
<html>
	<head>
		<title>Online Compiler</title>
	</head>

	<body>
	<div id="whole">
		<div id="content">
			<table class="code">
				<td class="code">	
				<form action="c.php" method="post" id="form">
	
					<strong>Enter Your code here:<br/></strong>
					<textarea name="code" rows=15 cols=100 onkeydown=insertTab(this,event) id="code"></textarea><br/>
					<span id="errorCode" class="error"></span><br/><br/>
					<strong>Sample Input please:<br/></strong>
					<textarea name="input" rows=7 cols=100 id="input"></textarea><br/><br/>
					<input type="submit" value="Submit" id="submit">
					<input type="reset" value="Reset"><br/>
				</form>
				</td>
		</div>
		</div>
	
	</body>
</html>
