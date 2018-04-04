<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BabbleTimeline</title>
    <style type="text/css">
        * {
            margin:0;
            padding:0;
        }

        body{
            text-align:center;
            background: #efe4bf none repeat scroll 0 0;
        }

        #wrapper{
            width:960px;
            margin:0 auto;
            text-align:left;
            background-color: #fff;
            border-radius: 0 0 10px 10px;
            padding: 20px;
            box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
        }

        #header{
            color: #fff;
            background-color: #2c5b9c;
            height: 3.5em;
            padding: 1em 0em 1em 1em;

        }

        #site{
            background-color: #fff;
            padding: 20px 0px 0px 0px;
        }
        .centerBlock{
            margin:0 auto;
        }
    </style>

<body>
<div id="wrapper">
    <div id="header">
        <h1> Babble TimeLine</h1>

    </div>

    <div id="site">
         <#list listbabble as babblelist>
             <tr>
                 <td><a href="http//localhost:8080/babbledetail?babbleId=${babblelist.id}">${babblelist.id}</a> </td>
                 <td>  ${babblelist.creator} </td>
                 <td><p>${babblelist.text}</p></td>
                 <td>${babblelist.created}</td>
                 <td><${details_babbles.likes}/td><td>${details_babbles.dislike}${details_babbles.rebabbles}</td>
             </tr>

         </#list>


    </div>
</div>
</body>
</html>