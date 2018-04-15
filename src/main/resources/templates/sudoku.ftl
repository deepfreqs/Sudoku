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
		#links {
		  float: left;
		  width: 20%;
		  height: 300px;
		  background-color: white;
			margin-right:5%;
			text-align:center; 
			margin: 0px auto
		}
		#rechts {
		  float: left;
		  width: 20%;
		  height: 300px;
		  background-color: khaki;
		}
		#inhalt {
		  float: left;
		  width: 40%;
		  margin: 1px;
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
			width:15em;
			height:40px;
		  background-color: SKYBLUE;
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
		input.numberlist
			text-align:center;
			width:161em;
			height:100%;
			background-color:GREENYELLOW;
			font-size:20px;
		}
		select.formSingleSelect{
        overflow:hidden;
        text-align-all:center;
		  border: 0px;
			height: 100%;
			width: 100%;
		  background-color: GREENYELLOW;
			font-size:30px;
		}
		
    </style>
</head>


<body>

	<div id="header">
		<h2 text-align="center" class="hello-title">Hello first Sudoku!</h2>
	</div>
	
	<@spring.bind "sudokuForm"/>
	<form action="" method="GET">
	<div id="links" >
			<button class="submit" type="submit" name="action" value="next">Next Step</button>
			<button class="submit" type="submit" name="action" value="new">Reset all Fields</button>
			<button class="submit" type="submit" name="action" value="load">Load from Number List</button>
			<@spring.bind path="sudokuForm.importSudoku"/>			
			<input class="numberlist" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
			<div>
			Enter a string of 81 numbers<br> (you can express blanks as 0, *, or '.')
			</div>
	</div>
	
	<div id="inhalt">
		<table style="border:1px;background-color: DARKKHAKI;width:750px;">
			<#assign seq = ['11', '12', '13', '21', '22', '23', '31', '32', '33']>
			<#list seq?chunk(3) as row>
			<tr> <!-- Zeile mit 3 Zeilen von Quadraten -->
				<#list row as cell>
				<td>
					<table style="border:2px;margin:none;"> <!-- das 9x9 Zellen Quadrat -->
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].a1"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].a1", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].b1"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].b1", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].c1"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].c1", 'class=cell'/>
								</#if>
							</td>
						</tr>
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].a2"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].a2", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].b2"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].b2", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].c2"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].c2", 'class=cell'/>
								</#if>
							</td>
						</tr>
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].a3"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].a3", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].b3"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].b3", 'class=cell'/>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].c3"/>
								<#if spring.status.value?length &lt; 2>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.formTextarea "sudokuForm.sudokuSquares[${cell}].c3", 'class=cell'/>
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

	<!-- div id="rechts"></div-->
	</form>
	
</body>
</html>