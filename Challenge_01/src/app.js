// Challenge_01 ORACLE_ON Turma 05 GHM

let msg = undefined;              
let pointer = undefined;          

/* Criptografia e Decriptografia colam o retorno na área de texto */
function encriptMsg() {
   msg = document.getElementById('mensagem').value = encode(document.getElementById('mensagem').value);
   checkMsg();
};

function decriptMsg() {
   msg = document.getElementById('mensagem').value = decode(document.getElementById('mensagem').value);
   checkMsg();
};

// Retorna o tipo de pointer
window.addEventListener("pointerdown", getInputType, false);

function getInputType(event) {
   pointer = String(event.pointerType);
};

//Mantem a consistência das maensagens em tela
function checkMsg() {
    
   //Se a mesnsagem for nula
   if (document.getElementById('mensagem').value == '') {

      // Se for uma tela touch , havendo um botão copiar remova-o
      if (pointer != "mouse" && document.getElementById("copiar")) {
         document.getElementById("copiar").remove();         
      };
      //Executa sem checar  mouse ou botão copiar
      document.querySelector(".retorno").querySelector('h1').innerHTML = "<h1>Nenhuma mensagem encontrada</h1>";
      document.querySelector(".retorno").querySelector('p').innerHTML = "<p>Digite um texto que você deseja criptografar ou descriptografar</p>";

   } else {       //Se a area de texto  não estiver vazia
      // Se a tela for touch
      if (pointer != "mouse") {
         // Se a orientação for portrait Não Desktop ou tamanho vertical maior que 768 e landscape
         if(screen.orientation.type == "portrait-primary" || 
           (window.innerWidth > 768) && screen.orientation.type =="landscape-primary"){
            document.querySelector(".retorno").innerHTML ="\
            <img class='figura' src='./img/figure.svg' alt='busca'>\
            <h1>Mensagem encontrada</h1>\
            <div id='copiar' class='botoes'>\
            <input type='button' value='Copiar' class='button' onclick='copClipboard()'>";
         }else{
         //Se for uma tela touch menor 768 para qualquer orientação - Não haverá imagem "busca"
         //E será criado um botão copiar
         document.querySelector(".retorno").innerHTML = "<h1>Mensagem encontrada</h1>\
         <div id='copiar' class='botoes'>\
         <input type='button' value='Copiar' class='button' onclick='copClipboard()'>";
         };
//verificar forma de append HTLM near selector
      } else {
         // Se pointer for mouse == Desktop
         document.querySelector(".retorno").querySelector('h1').innerHTML = "<h1>Mensagem encontrada</h1>";
         document.querySelector(".retorno").querySelector('p').innerHTML = "<p>Click dublo para copiar a mensagem para o clipboard.</p><br>";
      };
   };
};

//Copiar a área de texto para o clipboard no click dublo ou botao copiar
function copClipboard() {

   //Se houver Mensagem
   if (document.getElementById('mensagem').value != '') {
      navigator.clipboard.writeText(document.getElementById('mensagem').value);
      document.querySelector(".retorno").querySelector('h1').innerHTML = "<h1>Mensagem copiada</h1>";
      document.querySelector(".retorno").querySelector('p').innerHTML = "<p>Digite um texto que você deseja criptografar ou descriptografar.</p>";
   }else{
      checkMsg(); //Manter  Coerência de estado
   }    
};

