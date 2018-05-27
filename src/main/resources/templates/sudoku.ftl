<#import "spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start a Sudoku!</title>
    <style>


		body {
		  margin: 20px 2%;
		  padding: 0px;
		  background-color: khaki;
		}
		#header {
		  float: none;
		  width: 100%;
		  height: 100px;
			text-align:center; 
		  margin: 10px;
		  background-color: red;
		}
		#links {
		  float: left;
		  width: 20%;
		  height: 600px;
			text-align:center; 
		  margin: 30px;
		  background-color: khaki;
		}
		#rechts {
		  float: left;
		  width: 20%;
		  height: 600px;
		  margin: 30px;
			text-align:center; 
		  background-color: khaki;
		}
		#inhalt {
		  float: left;
		  width: 40%;
		  margin: 30px;
			align:center; 
		  background-color: khaki;
		}

		table.nope {
			table-layout:fixed;
			margin-left:10%;
		}
		tr.nope {
			height:600px;
		}
		td.cell {
			width:72px;
			height:72px;
			border:1px solid blue;
			overflow:hidden;
			text-align-all:center;
			margin:none;
			font-size:40px;
		}

		button.submit {
			text-align:center;
			margin:10%;
			width:300px;
			height:50px;
			border-radius: 10px;
		  background-color: SKYBLUE;
			font-size:15px;
		}
		input.cell{
			text-align:center;
			width:72px;
			height:72px;
			background-color:DARKKHAKI;
			font-size:50px;
		}
		textarea.cell{
			text-align:center;
			width:70px;
			height:100%;
			background-color:GREENYELLOW;
			font-size:15px;
		}
		textarea.sudokuInput
			text-align:center;
			rows:20;
			cols:40;
			width:250px;
			height:100px;
			background-color:SKYBLUE;
			font-size:15px;
		}
		select.formSingleSelect{
			text-align:center;
		  border: 0px;
			border-radius: 10px;
			width:200px;
			height:50px;
		  background-color: GREENYELLOW;
			font-size:15px;
		}
		
    </style>
</head>


<body>

	<div id="header">
		<h2 text-align="center" class="hello-title">Hello first Sudoku!</h2>
	</div>
	
	<@spring.bind "sudokuForm"/>
	<form action="" method="GET">
	<div id="links">
			<button class="submit" type="submit" name="action" value="new">Edit a Sudoku in the playground</button>
			<hr>
			<button class="submit" type="submit" name="action" value="load">Load one from list</button>
			<@spring.bind "sudokuForm.playThis" />
			<@spring.formSingleSelect "sudokuForm.playThis", sudokuList, 'style="text-align:center;border-radius:10px;width:300px;height:50px;background-color:LIGHTBLUE;font-size:15px;"' />
			<div>
			<hr>
			<button class="submit" type="submit" name="action" value="import">Import a predefined Sudoku</button>
			<@spring.bind path="sudokuForm.importSudoku"/>			
			<textarea class="sudokuInput" style="width:250px;height:100px;border-radius:10px;" name="${spring.status.expression}">${spring.stringStatusValue}</textArea>
			</div>
			<div style="font-size:15px;">
			Enter a string of 81 numbers<br> (you can express blanks as 0, *, or '.')
			</div>
	</div>
	
	<div id="inhalt">
		<table style="border:0px;background-color: DARKKHAKI;width:750px;">
			<#assign seq = ['11', '12', '13', '21', '22', '23', '31', '32', '33']>
			<#list seq?chunk(3) as row>
			<tr> <!-- Zeile mit 3 Zeilen von Quadraten -->
				<#list row as cell>
				<td>
					<table style="border:0px;margin:none;"> <!-- das 9x9 Zellen Quadrat -->
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].a1"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].a1", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].b1"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].b1", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].c1"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].c1", 'class=cell'/>
								</#if>
							</td>
						</tr>
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].a2"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].a2", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].b2"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].b2", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].c2"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].c2", 'class=cell'/>
								</#if>
							</td>
						</tr>
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].a3"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].a3", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].b3"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].b3", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sqs[${cell}].c3"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sqs[${cell}].c3", 'class=cell'/>
								</#if>
							</td>
						</tr>
					</table>
				</td>
				</#list>
			</tr>
			</#list>
		</table>
	</div>

	<div id="rechts">
		<div>
			<button class="submit" type="submit" name="action" value="next">Next Step</button>
			<button class="submit" type="submit" name="action" value="solve">Try to solve!</button>
			<button class="submit" type="submit" name="action" value="strategy">Choose strategy (not working yet)</button>
			<br/>
		</div>
		<div>
		</div>
		<div>
		</div>
	</div>

	</form>
	
</body>
</html>