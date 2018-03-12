"use strict"
$(document).ready(function () {
    $("#addNewScheduleFormID").hide();
    $("#displayAllList").hide();
    $(".error").hide();
});
    function openForm() {
        $("#addDateId").empty();
        $("#addTimeId").empty();
        $("#addDescID").empty();
        $(".error").hide();

        $("#addNewScheduleFormID").show();
        $("#NewScheduleId").hide();
    }

    function searchByDesc() {

        $("#addNewScheduleFormID").hide();
        $("#NewScheduleId").show();
        $("#displayAllList").empty();
        $("#serchTextID").empty();


        $("#displayAllList").show();
        getAllSchedule($("#serchTextID").val());
        console.log("getAllSchedule"+ $("#serchTextID").val() );
    }

    function getAllSchedule(data) {
        $("#displayAllList").empty();

        var url = " ";
        if (data === undefined || data == null || data.length <= 0)
            url = "/apex/displayAllSchedule";
        else url = "/apex/findByDescription";


        $.ajax({
            url: url,
            method: "GET",
            data: {"description": data},
            contentType: 'application/json; charset=utf-8',
            type: 'JSON',
            success: function (response) {
                $("#displayAllList").empty();
                if(response.length==0)
                    response.push({"serialNo": 0,"date":"No Date","time":"-----","description":"------"});
                var trHTML = '<tr><td>' + 'SN.    ' + '</td><td>' + 'DATE    ' + '</td><td>' + 'TIME    ' + '</td><td>' + '   DESCRIPTION' + '</td></tr>';
                $.each(response, function (i, item) {
                    trHTML += '<tr><td>' + item.serialNo + '</td><td>' + item.date + '</td><td>' + item.time + '</td><td>' + item.description + '</td></tr>';
                });
                $("#displayAllList").append(trHTML);
            }
        });


    }


    function addSchedule() {
        var data = {
            "date": $("#addDateId").val(),
            "time": $("#addTimeId").val(),
            "description": $("#addDescID").val()
        }
        var isvalid = validateDatetime(data);
        if (!isvalid) {
            console.log("invalidaate");
            $(".error").show();
            $("#NewScheduleId").show();
            return;

        } else {
            console.log("validaate");
            $(".error").hide();
            $("#addNewScheduleFormID").hide();
        }
        saveTOApexDB(data);
        $("#NewScheduleId").show();
        $("#serchTextID").show();
        $("#displayAllList").show();
    }

function saveTOApexDB(data){
    $.ajax({
        url: "/apex/saveSchedule",
        method: "POST",
        data : JSON.stringify(data),
        contentType: 'application/json; charset=utf-8',
        type: 'JSON',
        success: function (response) {
            console.log(response);


        },
        complete: function(){
            getAllSchedule();

        }
    });

}


    function cancelForm() {
        $("#serchTextID").empty();

        $("#addNewScheduleFormID").hide();
        $("#NewScheduleId").show();
        $("#serchTextID").show();
        $(".error").hide();
    }


    function validateDatetime(data) {
console.log(data);
        var selectedDate = new Date(data.date);
        selectedDate.setDate(selectedDate.getDate()+1);
        console.log("selected date= "+ selectedDate);
        var selectedhoursMinute=data.time.split(":");
        var selectedhours= parseInt(selectedhoursMinute[0]);
        var selectedMinute= parseInt(selectedhoursMinute[1])
        console.log("********"+ selectedhours+"     ----"+selectedMinute);

        selectedDate.setHours(selectedhours,selectedMinute)
        console.log("after changing hours"+ selectedDate);
        var now = new Date();
        console.log("now date: "+ now);
        if (selectedDate.getTime() > now.getTime()) {
            return true;
        } else {
                return false;
        }

    }


