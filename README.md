# Compactação de String
 
#### João Lucas Morais Carvalhido

## Problema


Usando a string: **UNIÃO PIONEIRA DE INTEGRAÇÃO SOCIAL**

![compacta-2](https://user-images.githubusercontent.com/57717791/76476388-a4fba200-63e0-11ea-95fb-80c50515a10b.PNG)

 
•	Quantidade de letras que se repetem: \
•**I**   -> 5 \
•**O**   -> 5 \
•**A**   -> 3 \
•**E**   -> 3 \
•**N**   -> 3 \
•**Ã**   -> 2 \
•**R**   -> 2

**Total de Repetições: 23**


-> Agora Imagine que você tenha essa mesma string “**UNIÃO PIONEIRA DE INTEGRAÇÃO SOCIAL**” 

e seja necessário ser repetida **2048** vezes em um texto armazenado em uma memória de **500 Kb**.



•Quantidade de caracteres inicial: 	**35**\
•Quantidade de caracteres final: 	35 * 2048	= **71.680**\
•Total em bits:                                 	71.680 * 8	= **573.440 Bits**\
•Quantidade de repetições inicial: 	**23**\
•Quantidade de repetições final: 	23 * 2048	= **47.104**\
•Total em bits: 	47.104 * 8 	= **376.832 Bits**\
•Espaço usado pelos caracteres:              	**573,440 Kb**\
•Espaço usado pelas repetições: 	**376,832 Kb**\
•Espaço da memória: 	**500,000 Kb** \
•Espaço sobressalente: 	**73,440 Kb**


Portanto, devido ao desperdício ocasionado pelas repetições,
fica evidente a falta de espaço necessário para que esses dados sejam devidamente armazenados,
sendo assim o uso de um compactador se torna uma ferramenta indispensável. 


## Definição da Solução 
### 1.	Tipos de compactação
####	RLE(Run Lenght Encoding)
-> Baseia-se na repetição de elementos consecutivos;
-> Codifica um elemento e da o número de repetições.

**Exemplos**
-> A cadeia “**AAAAHHHHHHHHHHHHHH**” comprimida da “**5A14H**”;

-> Tendo uma String “**AAAAABBBBCDDDDDD**” ao usar o **RLE** acaba ficando com “**5A4B1C6D**”.

#### Codificação de Shannon-Fano

![compacta-2-1](https://user-images.githubusercontent.com/57717791/76476875-5222ea00-63e2-11ea-8766-335f1b3ebbd9.PNG)

•Gera códigos de tamanho variável;

•Criado por Claude Shannon;                       
•Conjunto de dados a ser comprimido;
•Semelhante ao de Huffman.


#### Codificação de Huffman

![compacta-4](https://user-images.githubusercontent.com/57717791/76477020-ce1d3200-63e2-11ea-9241-feb4ee73d803.PNG)



•	Nesse método a estatística é a base da compactação;
•	Junção dos símbolos de menor probabilidade;
•	E realocado no conjunto de símbolos;

**Exemplo:**

![compacta-5](https://user-images.githubusercontent.com/57717791/76477234-7206dd80-63e3-11ea-82b6-d921162c49fa.PNG)

• Podemos construir a arvore binária:

![compacta-6](https://user-images.githubusercontent.com/57717791/76477338-c742ef00-63e3-11ea-8147-2118900b38b3.PNG)


•	Quanto mais frequente uma letra, Menos bits para representá-la.

•	A letra A (a mais frequente) é representada por um único bit: 1;
 
•	Quanto ao I (um pouco menos frequente), utilizamos dois bits: 00;

•	Quanto ao O (menos frequente ainda), utilizamos 3 bits : 010. 

•	Em binário, de acordo com a tabela ASCII, a palavra "MAISON" se escreve: 

![compacta-7](https://user-images.githubusercontent.com/57717791/76477340-c7db8580-63e3-11ea-800f-301b0182dc28.PNG)


 
•	No Huffman (com nossa árvore acima), ele se torna: 

![compacta-8](https://user-images.githubusercontent.com/57717791/76478522-b09e9700-63e7-11ea-8d9b-7b2a6daf95bc.PNG)

 
#### Lempel-Ziv
•	Melhor e mais utilizado algoritmo de compactação na atualidade;

• Baseada em dicionário que codifica strings de símbolos;

• Possui duas áreas de trabalho:\
**Dicionário**	->  Onde ficam armazenadas as informações codificadas.
 
**Área de pesquisa** ->  Onde fica a String a comprimir.

•	Método consiste em:

-> Atribuição e Registração.

**Vantagens e Desvantagens


Vantagens:
  
    •	Compactação correta;

    •	Facilidade na programação;

    •	Usar dicionário de tamanhos variados.
    
    
Desvantagens:
  
    •	Arquivo sem repetição e muito curto;

    •	Espaço significativo na memória.
    

-> Utilizando o mesmo exemplo da definição da problema, agora atribuindo a solução:

**1.	Dicionário:**  

![compacta-9](https://user-images.githubusercontent.com/57717791/76478917-e4c68780-63e8-11ea-87f8-5f45d802acb2.PNG)


**2.	Convertendo “UNIÃO PIONEIRA DE INTEGRAÇÃO SOCIAL” para as referências do dicionário:**


![compacta-10](https://user-images.githubusercontent.com/57717791/76478913-e3955a80-63e8-11ea-829c-e81b5217a7ca.PNG)
 
**3.	Seguindo a tabela ASCII, a representação de bits para cada referência:** 


![compacta-11](https://user-images.githubusercontent.com/57717791/76478915-e42df100-63e8-11ea-957e-27260f9ef3e4.PNG)
 
•	**4. Resultado:**


•	Tamanho do Dicionário: **17**

•	Tamanho da Frase Compactada: **35**

•	Quantidade de bits da frase completa: **573.440**

•	Quantidade de bits da frase compactada: **206.848**

•	Proporção da redução: **62,1%**
