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
		  background-color: khaki;
			margin-right:10%;
		}
		#rechts {
		  float: left;
		  width: 20%;
		  height: 300px;
		  background-color: #ffcc00;
		}
		#inhalt {
		  float: left;
		  width: 60%;
		  margin: 10px 2%;
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
			width:80px;
			height:80px;
			border:1px solid blue;
			overflow:hidden;
			text-align-all:center;
			margin:none;
			font-size:40px;
		}

		button.submit {
			text-align:center;
			margin: 20%;
			width:12em;
			height:40px;
		  background-color: SKYBLUE;
		}
		input.cell{
			text-align:center;
			width: 100%;
			height: 100%;
			background-color: SALMON;
			font-size:50px;
		}
		input.formRadioButtons{
		  border: 0px;
			height: 2em;
			width: 100%;
		  background-color: SKYBLUE;
			font-size:5px;
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
	<div id="links" style="text-align:center; margin: 0px auto">
			<button class="submit" type="submit" name="action" value="next">Nächster Schritt</button>
			<button class="submit" type="submit" name="action" value="new">Neues Spiel</button>
	</div>
	
	<div id="inhalt">
		<table style="border:1px;background-color: DARKKHAKI;width:100%;">
			<#assign seq = ['11', '12', '13', '21', '22', '23', '31', '32', '33']>
			<#list seq?chunk(3) as row>
			<tr> <!-- Zeile mit 3 Zeilen von Quadraten -->
				<#list row as cell>
				<td>
					<table style="border:2px;margin:none;"> <!-- das 9x9 Zellen Quadrat -->
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].a1"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "A1">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].a1", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].b1"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "B1">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].b1", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].c1"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "C1">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].c1", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
						</tr>
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].a2"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "A2">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].a2", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].b2"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "B2">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].b2", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].c2"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "C2">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].c2", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
						</tr>
						<tr>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].a3"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "A3">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].a3", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].b3"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "B3">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].b3", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
								</#if>
							</td>
							<td class="cell">
								<@spring.bind path="sudokuForm.sudokuSquares[${cell}].c3"/>
								<#if spring.status.value??>
									<input class="cell" type="text" name="${spring.status.expression}" value="${spring.status.value}" />
								<#else>
									<@spring.bind path="sudokuForm.sudokuSquares[${cell}].options"/>
									<#list spring.status.value as key, value>
										<#if key = "C3">
											<@spring.formSingleSelect "sudokuForm.sudokuSquares[${cell}].c3", value, 'class="formSingleSelect"'/>
										</#if>
					  			</#list>
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