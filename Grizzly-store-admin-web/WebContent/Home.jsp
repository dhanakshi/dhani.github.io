<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<style>
.button
{
  border-radius:10px;
}
#container
{
  background-color:#F2F2F2;
  width:100%;
  height:70px;
}
#container2
{
  background-color:#F2F2F2;
  width:22%;
  float:left;
  height:400px;
  margin-top:30px;
  margin-left:20px;
  padding-top:5px;
}
#container3
{
  background-color:#FFFFFF;
  width:100%;
  height:70px;
  margin-top:180px;
}
#container4
{
  background-color:#FFFFFF;
  height:200px;
  width:35%;
  padding-left:450px;
}
#container5
{
  background-color:#EEEEEE;
  width:30%;
  height:250px;
  padding-right:5px;
  margin-left:35px;
  margin-top:45px;
  float:left;
}
.bute
{
  background-color:#F2F2F2;
  border:none;
  color:black;
  padding: 18px 32px;
  text-align:center;
  text-decoration: none;
  display:inline-block;
  font-size:12px;
  margin:5px 2px;
  cursor:pointer;
}
.bu
{
  margin-left:35px;
}
#box1
{
  background-color:#B9B9B9;
  width:96%;
  height:30px;
  padding-top:5px;
  margin-bottom:20px;
  margin-left:5px;
}
#profile
{
  background-color:#B9B9B9;
  color:#FFFFFF;
  float:left;
  padding-left:5px;
  padding-top:5px;
}
.success
{
  color:white;
  float:right;
}
.bttn
{
  background-color:#B9B9B9;
  margin-left:110px;
  padding-left:5px;
  padding-right:5px;
  padding-top:2px;
  border:none;
  cursor:pointer;
  display:inline-block;
}
#profile-pic
{
  background-color:#B9B9B9;
  width:35%;
  height:100px;
}
#username
{
  color:black;
  margin-top:10px;
}
#data
{
  color:black;
  margin-top:10px;
}
.btn
{
  border: none;
  background-color: #C1C1C1;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  display: inline-block; 
}
.btn:hover
{
  background: #8A8A8A;
}
.pro
{
  color:black;
  float:left;
  font-size:18px;
  width:25%;
  margin-top:30px;
  margin-left:35px;
  padding-top:5px;
  height:50px;
}
.ven
{
  color:black;
  float:left;
  font-size:18px;
  width:25%;
  margin-top:30px;
  padding-top:5px;
  height:50px;
}
.but
{
  border: none;
  background-color: white;
  color:black;
  padding: 14px 28px;
  font-size: 14px;
  cursor: pointer;
  display: inline-block;
  outline:none;
}
.bt
{
  margin-top:30px;
}
#top
{
  background-color:#F2F2F2;
}
#top1
{
  background-color:#FFFFFF;
  width:100%;
  height:500px;
}
#image
{
  background-color:F2F2F2;
  float:left;
  padding-left:10px;
}
#search
{
  background-color:F2F2F2;
  float:left;
  padding-left:10px;
  margin-top:27px;
}
#bell
{
  background-color:F2F2F2;
  float:right;
  margin-top:23px;
  padding-right:5px;
}
#welcome
{
  background-color:F2F2F2;
  float:right;
  padding-left:5px;
  padding-right:5px;
  margin-top:26px;
}
#logout
{
  float:right;
  background-color:#F2F2F2;
  padding-left:5px;
  padding-right:20px;
  margin-top:25px;
}
.on
{
  border:none;
  color:white;
  background-color:inherit;
  padding: 14px 28px;
  font-size:12px;
  cursor:pointer;
  display:inline-block;
  margin-left:95px;
  margin-top:60px;
}
.plus
{
  margin-right:80px;
  border-style:dotted;
  border-color:gray;
  color:gray;
  font-size:75px;
}
.plus:hover
{
  background-color:#A0A0A0;
}
.add
{
  background-color:#F2F2F2;
  float:right;
  padding-right:10px;
}
.cancel
{
  background-color:#F2F2F2;
  float:right;
}
.add:hover
{
  background-color:#A0A0A0;
}
.cancel:hover
{
  background-color:#A0A0A0;
}
</style>
</head>
<body>

 <div id="container">
 <div id="top">
 
 <div id="image">
   <img src="C:\Users\768853\workspace\Grizzly-store-admin-web\WebContent\Project\addproduct.jpg" height="70px">
   </div>
 <div id="search">
   <input type="text" name="search" placeholder="Search" class="button">
 </div>
 <div id="logout">
   <button type="submit" class="button">Logout</button>
 </div>
 <div id="welcome">
    Welcome, <%=request.getAttribute("username") %>
 </div>
 <div id="bell">
   <img src="C:\Users\768853\workspace\Grizzly-store-admin-web\WebContent\Project\bell.jpg" height="25px">
 </div>
 </div>
 <br><br>
 </div>
 
 
 <div id="top1">
 <div id="container2">
   <div id="box1">
     <div id="profile">
       <B>PROFILE</B>
       <B><button class="bttn success">Edit</button></B>
     </div>
   </div>
  <center> <div id="profile-pic">
   </div></center>
   <div id="username">
     <B><center><%=request.getAttribute("username") %></center></B>
   </div>
   <center><div id="data">
   ID<br>
    <B><center><%=session.getAttribute("id") %></center></B>
   <br>
   DESIGNATION<br>
    <B><center><%=session.getAttribute("desig") %></center></B>
   <br>
   OFFICE<br>
    <B><center><%=session.getAttribute("office") %></center></B>
   <br>
   </div></center>
 </div>
 
   <div id="pro">
     <B><button class="btn pro">PRODUCTS</button></B>
   </div>
   <div id="ven">
     <B><button class="btn ven">VENDORS</button></B>
   </div>
   <div id="container5">
    <center><button class="on plus">+</button></center>
    <center>Add Images</center>
   </div>
   <div id="container4">
   <div>
     <input type="text" name="" placeholder="Enter Product ID" class="but bt">
   </div>
   <div>
     <select class="but">
       <option value="category">Category</option>
       <option value="trimmer">Trimmer</option>
       <option value="shaver">Shaver</option>
       <option value="micro-pens">Micro-pens</option>
     </select>
   </div>
   <div>
     <input type="text" name="" placeholder="Name" class="but">
   </div>
   <div>
     <input type="text" name="" placeholder="Description" class="but">
   </div>
   <div>
     <input type="text" name="" placeholder="Price" class="but">
   </div>
   </div>
   <div id="container3">
   <button class="bute bu">2</button>
   <button class="bute">3</button>
   <button class="bute">4</button>
   <button class="bute">5</button>
   <button class="cancel button">Cancel</button>
   <button class="add button">Add</button>
   </div>
</div>
 

</body>
</html>