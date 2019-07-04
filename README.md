<body lang="pt-BR" dir="ltr">
<p style="margin-bottom: 0in; line-height: 100%"># starWars</p>
<p style="margin-bottom: 0in; line-height: 100%" Project using maven, spring MongoDB, Jersey />
<p style="margin-bottom: 0in; line-height: 100%" Link of POSTMAN REQUEST /></p>
https://www.getpostman.com/collections/fff4dd9d2af3614afb9e</p>
<p style="margin-bottom: 0in; line-height: 100%"></p>
<p style="margin-bottom: 0in; line-height: 100%">DELETE &gt;
http://localhost:8081/star_wars/rest/planets/7</p>
<p style="margin-bottom: 0in; line-height: 100%">POST &gt;
http://localhost:8081/star_wars/rest/planets/ + Json of Planet  
</p>
<p style="margin-bottom: 0in; line-height: 100%">{</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Tatooine&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;desert&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;arid&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
1</p>
<p style="margin-bottom: 0in; line-height: 100%">    }</p>
<p style="margin-bottom: 0in; line-height: 100%">    
</p>
<p style="margin-bottom: 0in; line-height: 100%">PUT &gt;
http://localhost:8081/star_wars/rest/planets/4 + Json of the Planet
for change</p>
<p style="margin-bottom: 0in; line-height: 100%">{</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Hoth&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;tundra, ice caves, mountain ranges, caverns&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;frozen&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
4</p>
<p style="margin-bottom: 0in; line-height: 100%">    }</p>
<p style="margin-bottom: 0in; line-height: 100%"><br/>

</p>
<p style="margin-bottom: 0in; line-height: 100%">GET : ALL &gt;
return all list :http://localhost:8080/starWars/rest/planets/</p>
<p style="margin-bottom: 0in; line-height: 100%">GET : By Id &gt;
return just one: http://localhost:8080/starWars/rest/planets/2</p>
<p style="margin-bottom: 0in; line-height: 100%">GET : By Name  &gt; 
 searching by name
:http://localhost:8080/starWars/rest/planets/?name=Alderaan</p>
<p style="margin-bottom: 0in; line-height: 100%"><br/>

</p>
<p style="margin-bottom: 0in; line-height: 100%"><br/>

</p>
<p style="margin-bottom: 0in; line-height: 100%"><br/>

</p>
<p style="margin-bottom: 0in; line-height: 100%"><br/>

</p>
<p style="margin-bottom: 0in; line-height: 100%">examples of jason
used to populate</p>
<p style="margin-bottom: 0in; line-height: 100%">[</p>
<p style="margin-bottom: 0in; line-height: 100%">    {</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Tatooine&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;desert&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;arid&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
1</p>
<p style="margin-bottom: 0in; line-height: 100%">    },</p>
<p style="margin-bottom: 0in; line-height: 100%">    {</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Alderaan&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;grasslands, mountains&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;temperate&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
2</p>
<p style="margin-bottom: 0in; line-height: 100%">    },</p>
<p style="margin-bottom: 0in; line-height: 100%">    {</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Yavin IV&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;jungle, rainforests&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;temperate, tropical&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
3</p>
<p style="margin-bottom: 0in; line-height: 100%">    },</p>
<p style="margin-bottom: 0in; line-height: 100%">    {</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Hoth&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;tundra, ice caves, mountain ranges&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;frozen&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
4</p>
<p style="margin-bottom: 0in; line-height: 100%">    },</p>
<p style="margin-bottom: 0in; line-height: 100%">    {</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;name&quot;:
&quot;Dagobah&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;terrain&quot;:
&quot;swamp, jungles&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;climate&quot;:
&quot;murky&quot;,</p>
<p style="margin-bottom: 0in; line-height: 100%">        &quot;_Id&quot;:
5</p>
<p style="margin-bottom: 0in; line-height: 100%">    }</p>
<p style="margin-bottom: 0in; line-height: 100%">]</p>
</body>
</html>
