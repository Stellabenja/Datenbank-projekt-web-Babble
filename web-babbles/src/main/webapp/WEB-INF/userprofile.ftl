<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Userprofile</title>

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
        .profil{
            float:right;
        }
    </style>

<body>
<div id="wrapper">
    <div id="header">
        <h1> Babble Userprofile </h1>

    </div>

    <div id="site">
        <form>
            <p>
                <p class="profil">
                    <img src="parameter.photo"/>
                </p>
            <h2> Username: ${user} </h2>
            <h2> Name:${parameter.name} </h2>
            <h2> Status:${parameter.status}</h2>
            </p>
            <#list listbabble as babblelist>
             <tr>
                 <td><a href="http//localhost:8080/babbledetail?babbleId=${babblelist.id}">${babblelist.id}</a> </td>
                 <td>  ${babblelist.creator} </td>
                 <td><p>${babblelist.text}</p></td>
                 <td>${babblelist.created}</td>

             </tr>

            </#list>
        </form>
        <form >
            <button onclick="SITEBABBLE_SEARCH">Search Babble</button>
            <button onclick="SITEBABBLE">Follow/Unfollow</button>
            <button onclick="SITEBABBLE">Block/Unblock</button>
        </form>




    </div>
</div>
</body>
</html>