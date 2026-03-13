import { useState, useEffect } from "react";
import "./Catalago.css";

function Catalago() {
    const [livros, setLivros] = useState([]);
    const [loading, setLoading] = useState(true);

    const fetchLivros = async () => {
        try {
            const response = await fetch("http://localhost:8080/api/books/ListarBooks");

            if (response.ok) {
                const data = await response.json();
                setLivros(data);
            } else {
                console.error("Erro ao buscar livros: Status", response.status);
            }
        } catch (error) {
            console.error("Erro de conexão ao buscar catálogo:", error);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchLivros();
    }, []);

    if (loading) {
        return <div className="loading">Carregando catálogo...</div>;
    }

    return (
        <section className="catalogo">
            <h1 className="titulo-catalogo">Catálogo de Livros</h1>

            <div className="barra-busca">
                <select>
                    <option>Título</option>
                    <option>Autor da Review</option>
                </select>
                <input
                    type="text"
                    placeholder="Buscar livro..."
                />
            </div>

            <div className="lista-livros">
                {livros.length > 0 ? (
                    livros.map((livro) => (
                        <div className="card-livro" key={livro.id}>
                            <div className="capa-livro">
                                {livro.capa ? (
                                    <img
                                        src={livro.capa}
                                        alt={`Capa do livro ${livro.title}`}
                                        onError={(e) => { e.target.src = "https://via.placeholder.com/150?text=Sem+Capa"; }}
                                    />
                                ) : (
                                    <img src="https://via.placeholder.com/150?text=Sem+Capa" alt="Sem capa disponível" />
                                )}
                            </div>
                            <div className="info-livro">
                                <h3>{livro.title}</h3>

                                {livro.review ? (
                                    <div className="review-box">
                                        <p className="comentario-review">
                                            "{livro.review.comment}"
                                        </p>
                                        <span className="assinatura-autor">
                                            — {livro.autorReview || "Anônimo"}
                                        </span>
                                    </div>
                                ) : (
                                    <p className="comentario-review">Sem avaliação disponível.</p>
                                )}
                            </div>
                        </div>
                    ))
                ) : (
                    <p>Nenhum livro encontrado no banco de dados.</p>
                )}
            </div>
        </section>
    );
}

export default Catalago;