(() => {
    console.log('carregado 2');

    const form = new FormData();
    const myObject = {
        matricula: "F9329430",
        assunto: "Tesouro Direto",
        arquivo: ""
    };
    
    const convertFile = (file, done, fail) => {
       
            var reader = new FileReader;
            var name = file.name;
        
            reader.onload = function(evt) {
                done(name, evt.target.result);
            };
            reader.onerror = function(evt) {
                fail(name);
            };
            const conteudo = reader.readAsText(file);
            console.log("conteudo = ", conteudo); //assincrono - qdo termina chama onload
      
    }
    const leituraOK = (nome, resposta) =>{
        myObject.arquivo = resposta;
        console.log("Leitura ok");
        console.log(nome, resposta);
        postIncluirDados();

    };
    const leituraErro = (nome) =>{
        console.log("Falha ao ler:", nome);
    };
    const getInputForm = () => {
        console.log("get dados");
        const assunto = document.querySelector("[data-assunto]");
        const arquivo = document.querySelector("[data-arquivo]");
        console.log(assunto.value);
        console.log(arquivo.files[0]);
        
        convertFile(arquivo.files[0], leituraOK, leituraErro);

        const dados = {
            assunto: assunto.value,
            arquivo: 45
        }
        form.append(dados, JSON.stringify(dados));

    }

    const postIncluirDados = () => {

        console.log('objeto = ' + JSON.stringify(myObject));
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        //myHeaders.append("Content-Type", "text/plain");
        
        fetch('http://localhost:8080/cdiexample/api/upload', {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(myObject)
        })
        .then(response => {
            if (!response.ok)
                throw new Error("não foi possível completar cadastro");

            return response.text();
        })
        .then(data => alert(data));
    }

    const enviarDados = (evt) => {
        console.log("click");
        getInputForm();
    }
    
    const btenviar = document.querySelector("[data-bt-enviar]");
    btenviar.addEventListener("click", enviarDados);


})();

