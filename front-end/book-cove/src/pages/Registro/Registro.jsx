import { useState, useRef } from "react";
import "./Registro.css";

function Registro() {
  const initialState = {
    title: "",
    publisherName: "",
    autorname: [""],
    reviewComment: "",
    autorReview: "",
    capa: ""
  };

  const [bookData, setBookData] = useState(initialState);
  const fileInputRef = useRef(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setBookData(prev => ({ ...prev, [name]: value }));
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setBookData(prev => ({ ...prev, capa: reader.result }));
      };
      reader.readAsDataURL(file);
    }
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/api/books/criar-livro", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(bookData)
      });

      if (response.ok) {
        alert("Livro e imagem registrados com sucesso!");
        setBookData(initialState);
        if (fileInputRef.current) {
          fileInputRef.current.value = "";
        }
      } else {
        alert("Erro ao registrar.");
      }
    } catch (error) {
      console.error("Erro:", error);
    }
  };

  return (
    <main className="registro">
      <h1 className="titulo-registro">Registro de Livro</h1>
      
      <div className="registro-container">
        <div className="instrucoes">
          <h2>Instruções</h2>
          <p>
            Preencha os campos ao lado para catalogar uma nova obra na plataforma. 
            Certifique-se de que os nomes da publicadora e do escritor estejam corretos.
          </p>
          <p>
            Na seção de Review, escreva sua análise pessoal e identifique-se no campo 
            "Autor da Review" para que sua assinatura apareça no catálogo.
          </p>
          <p>
            O upload da capa é essencial para a identidade visual do livro no sistema.
          </p>
        </div>

        <div className="formulario">
          <div className="campo">
            <label>Título</label>
            <input name="title" value={bookData.title} onChange={handleChange} />
          </div>

          <div className="campo">
            <label>Publicadora</label>
            <input name="publisherName" value={bookData.publisherName} onChange={handleChange} />
          </div>

          <div className="campo">
            <label>Escritor</label>
            <input 
              value={bookData.autorname[0]} 
              onChange={(e) => setBookData({...bookData, autorname: [e.target.value]})} 
            />
          </div>

          <div className="campo">
            <label>Autor da Review</label>
            <input name="autorReview" value={bookData.autorReview} onChange={handleChange} />
          </div>

          <div className="campo">
            <label>Comentário</label>
            <textarea name="reviewComment" value={bookData.reviewComment} onChange={handleChange} />
          </div>

          <div className="campo-imagem">
            <label htmlFor="upload-capa" className="upload-label">Selecionar capa</label>
            <input 
              id="upload-capa" 
              type="file" 
              accept="image/*" 
              onChange={handleFileChange}
              ref={fileInputRef} 
            />
            {bookData.capa && <p style={{color: 'green'}}>Imagem carregada!</p>}
          </div>

          <button className="btn-registro" onClick={handleRegister}>Registrar Livro</button>
        </div>
      </div>
    </main>
  );
}

export default Registro;