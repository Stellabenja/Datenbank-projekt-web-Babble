<html>
<head>
    <meta charset="UTF-8">
    <title>Userliste von Babble</title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        body{
            text-align: center;
            background-color: aqua;
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

    </style>
 
<body>
    <div id="wrapper">
        <div id="header">
        <h1>BabbleUserliste</h1>
        </div>
        <div id="site">

 
  <table class="datatable">

    <#list users as user>
    <tr>
        
        <td><a href="http//localhost:8080/userprofile?userparameter=${user}">
            ${user}</a>
        </td>

    </tr>
    </#list>
  </table>
    </div>
    </div>
</body>
</html>