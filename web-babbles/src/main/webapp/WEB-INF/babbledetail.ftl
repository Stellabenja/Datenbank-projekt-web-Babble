<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Babble_detail</title>

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
        <h1> Babble's Detail </h1>

    </div>
    <div id="site">
        <tr>
            <td>${babbleobject.id}</td>
            <td>  ${babbleobject.creator} </td>
            <td><p>${babbleobject.text}</p></td>
            <td>${babbleobject.created}</td>
            <td><${details_babbles.likes}/td><td>${details_babbles.dislike}${details_babbles.rebabbles}</td>
        </tr>
        <div>
            <form action="Babble_details" method="post">
                <button type="submit" name="button1" value="Like">Like</button>
            <button type="submit" name="button2" value="dislike">dislike</button>
            <button type="submit" name="button3" value="rebabble">rebabble</button>
            <button type="submit" name="button3" value="deletebabble">deletebabble</button>


            </form>
        </div>


    </div>
</div>
</body>
</html>