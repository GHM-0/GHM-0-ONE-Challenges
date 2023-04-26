// Challenge_01 ORACLE_ON Turma 05 GHM

//Nunca inciar com strings vazias
let msg_in = undefined;   //Vai receber um String == Array de chars
let msg_out = undefined;  //Vai receber um String == Array de chars

//Dicionário  - A ordem da decodificação não importa,se a mensagem for obtida por inteiro
const subt= { e:"enter",i:"imes",a:"ai",o:"ober",u:"ufat" };

//Chave para valor
function encode(msg_in) {
  let msg=msg_in;
  //Busque as chaves
  for (let key of Object.keys(subt)) {               //retorne o valor para a chave
    msg = msg.replaceAll(key,Object.values(subt).find(value => subt[key] === value)); 
  }
  return msg;
};

//Valor para Chave
function decode(msg_out) {
  let msg=msg_out;
  //Busque os valores
  for (let value of Object.values(subt)) {           //retorne a chave para o valor
    msg = msg.replaceAll(value,Object.keys(subt).find(key => subt[key] === value));
  }
  return msg;
};

//Testar Inconsistência  
function check(msg_out) { 
  return msg_in === decode(msg_out);  //Verdadeiro ou Falso  undefined === undefined é falso
};