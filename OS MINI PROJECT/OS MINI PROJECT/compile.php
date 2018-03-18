<?php

	$languageID=$_POST["language"];
	
		switch($languageID)
			{
				case "c":
				{
					include("..\htdocs\compilers\c.php");
					break;
				}
				
				case "cpp":
				{
					include("..\htdocs\compilers\cpp.php");
					break;
				}
				case "java":
				{	
					include("..\htdocs\compilers\java.php");
					break;
				}
			
			}
?>
