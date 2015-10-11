<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link rel="stylesheet" type="text/css" href="menu.css" media="screen"/>
	<link rel="stylesheet" type="text/css" href="form_cadastro.css" media="screen"/>
	 <script> //evento links
        
            $(document).ready(function()
            {
                $("[href]").css("color","white");
                    $("#linka").mouseover(function() 
                    {
                        
                        $("#linka").css("color","deeppink");
                        
                    });
                    
                    $("#linkb").mouseover(function() 
                    {
                        
                        $("#linkb").css("color","deeppink");
                        
                    });
                    
                    $("#linkc").mouseover(function() 
                    {
                        
                        $("#linkc").css("color","deeppink");
                        
                    });
                    
                    $("#linkd").mouseover(function() 
                    {
                        
                        $("#linkd").css("color","deeppink");
                        
                    });
                    
                    $("#linke").mouseover(function() 
                    {
                        
                        $("#linke").css("color","deeppink");
                        
                    });
                    
                    $("#link1").mouseover(function() 
                    {
                        
                        $("#link1").css("color","deeppink");
                        
                    });
                    
                    $("#link2").mouseover(function() 
                    {
                        
                        $("#link2").css("color","deeppink");
                        
                    });
                    
                    $("li").first().mouseover(function() 
                    {
                        
                        $("#link_aluno1").css("color","deeppink");
                        
                    });
                    
                    $("[href]").mouseout(function()
                    {
                        
                        $("[href]").css("color","white");
                                
                    });
                    
                     $("li").mouseout(function()
                    {
                        
                        $("li").css("color","white");
                                
                    });
            });
            
        </script>
	<title>Sistema Monitoria - Cadastro</title>

</head>

<body>

	<table id="menu">
        
			<tr>
			
            	<td><a href="" id="linke">Login</a></td>
                <td><a href="login.do" id="linkc">Entrar</a></td>
               	<td><a href="" id="linkd">Cadastro</a></td>
                <td><a href="professor.jps" id="linka">Professor</a></td>
                <td><a href="" id="linkb">Aluno</a></td>
                        
            </tr>
                        
        </table>
        
	<form action="" method="post">
		
		<fieldset>
            
            <p>
                        
             	<label id="nome">Nome</label>
                <input type="text" id="nome1" name="nome" placeholder="Informe seu nome..." />
                        
            </p>
                    
            <p>
                        
				<label id="sobrenome">Sobrenome</label>
				<input type="text" id="sobrenome1" name="sobrenome" placeholder="Informe seu sobrenome..." />
                        
           	</p>
                    
             <p>
                        
             	<label id="matricula">Matr�cula</label>
				<input type="text" name="matricula" id="matricula1" placeholder="Informe sua matr�cula..." />
                        
		    </p>
                    
            <p>
                        
            	<label id="email">E-mail</label>
				<input type="email" name="email" id="email1" placeholder="Informe seu e-mail..." />
                        
		    </p>	
                    
            <p>
                        
            	<label id="password">Senha</label>
				<input type="password" id="password1" name="password" placeholder="Informe a sua senha..." />
                    
            </p>
                        
            <p>
                        
            	<label id="passconfirma">Confirmar senha</label>
				<input type="password" id="passconfirma1" name="passconfirma" />
                    
           </p>    
                    
            <p>
                
            	<input type="submit" value="Cadastrar" />
			
            </p>
                    
		</fieldset>
		
	</form>
	
	 <table id="rodape">
             
             <tr>
                 
                <td> <img src="logo-tads2.png" alt="logo do tads"/> </td>
                <td> <img src="ifpe.jpg" id="ifpe" alt="logo do ifpe"/> </td>
                
            </tr>
            
         </table>
         
</body>

</html>