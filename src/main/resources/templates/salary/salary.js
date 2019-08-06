$(document).ready(function () {
    $("#submitId").click(function () {
        if (validate(salary)) {
            increaseCalc();
            deductionCalc();
            predictionCalc();
        }
    });
    var salary = parseInt($("#inputSalary").val());
    var incrementFrequently = parseInt($("#inputIncrementFrequently").val());
    var increment = parseFloat($("#inputIncrement").val()) * incrementFrequently;
    var deductionFrequently = parseInt($("#inputDeductionsFrequently").val());
    var deduction = parseFloat($("#inputDeductions").val()) * deductionFrequently;
    var prediction = $("#inputPrediction").val();

    function increaseCalc() {
        var incrementHtml = "<thead>"
            + "	<tr>                                            "
            + "		<th scope='col'>Year</th>                   "
            + "		<th scope='col'>Starting Salary</th>        "
            + "		<th scope='col'>Number of Increments</th>   "
            + "		<th scope='col'>Increment %</th>            "
            + "		<th scope='col'>Increment Amount</th>       "
            + "	</tr>                                           "
            + "</thead>                                         ";
        var curSalary = salary;
        for (var i = 1; i <= prediction; i++) {
            incrementHtml += "<tr>";
            incrementHtml += "<td>" + i + "</td>"
            incrementHtml += "<td>" + curSalary + "</td>"
            incrementHtml += "<td>" + increment * +"</td>"
            incrementHtml += "<td>" + increment * 100 + "</td>"
            incrementHtml += "<td>" + increment * curSalary + "</td>"
            incrementHtml += "</tr>";
            curSalary = curSalary * (1 + increment * 1);
        }
        $("#table_increment").html(incrementHtml);
    }

    function deductionCalc() {
        var deductionHtml = "<thead>"
            + "	<tr>                                            "
            + "		<th scope='col'>Year</th>                   "
            + "		<th scope='col'>Starting Salary</th>        "
            + "		<th scope='col'>Number of deductions</th>   "
            + "		<th scope='col'>Deduction %</th>            "
            + "		<th scope='col'>Deduction Amount</th>       "
            + "	</tr>                                           "
            + "</thead>                                         ";
        var curSalary = salary;
        for (var i = 1; i <= prediction; i++) {
            deductionHtml += "<tr>";
            deductionHtml += "<td>" + i + "</td>"
            deductionHtml += "<td>" + curSalary + "</td>"
            deductionHtml += "<td>" + deduction + "</td>"
            deductionHtml += "<td>" + deduction * 100 + "</td>"
            deductionHtml += "<td>" + deduction * curSalary + "</td>"
            deductionHtml += "</tr>";
            curSalary = curSalary * (1 - deduction * 1);
        }
        $("#table_deduction").html(deductionHtml);
    }

    function predictionCalc() {
        var predictionHtml = "<thead>"
            + "	<tr>                                            "
            + "		<th scope='col'>Year</th>                   "
            + "		<th scope='col'>Starting Salary</th>        "
            + "		<th scope='col'>Increment Amount</th>     "
            + "		<th scope='col'>Deduction Amount</th>       "
            + "		<th scope='col'>Salary Growth</th>        "
            + "	</tr>                                           "
            + "</thead>                                         ";
        var curSalary = salary;
        for (var i = 1; i <= prediction; i++) {
            predictionHtml += "<tr>";
            predictionHtml += "<td>" + i + "</td>"
            predictionHtml += "<td>" + curSalary + "</td>"
            predictionHtml += "<td>" + increment * curSalary + "</td>"
            predictionHtml += "<td>" + deduction * curSalary + "</td>"
            predictionHtml += "<td>" + (increment * curSalary - deduction * curSalary) + "</td>"
            predictionHtml += "</tr>";
            curSalary = curSalary * (1 + increment * 1 - deduction * 1);
        }
        $("#table_prediction").html(predictionHtml);
    }

    function validate(salary, increment, incrementFrequently, deduction, deductionFrequently) {
        var flag = true;
        if (salary < 1) {
            flag = false;
            alert("salary less than 1");
        }
        if (increment < 0) {
            flag = false;
            alert("Do not accept a negative number for increment");
        }
        if (incrementFrequently < 1) {
            flag = false;
            alert("Do not accept a number less than 1 for frequency of increment");
        }
        if (deduction < 0) {
            flag = false;
            alert("Do not accept a negative number for deduction");
        }
        if (incrementFrequently < 1) {
            flag = false;
            alert("Do not accept a number less than 1 for frequency of increment");
        }
        return flag;
    }
});