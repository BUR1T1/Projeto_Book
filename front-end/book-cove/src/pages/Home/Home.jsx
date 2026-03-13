import { useNavigate } from 'react-router-dom'
import './Home.css'

function Home() {
    const navigate = useNavigate()

    const handleExplorarCatalogo = () => {
        navigate('/catalogo')
    }

return (
    <main className="home">
        <section className="home-container">

        <div className="home-header">
            <h1 className="home-title">
            Book Cover
            </h1>
            <div className="title-decoration"></div>
        </div>

        <p className="home-description">
        Plataforma desenvolvida para organização e exploração de catálogos
        de livros. O objetivo do sistema é permitir o registro de obras,
        gerenciamento de coleções e acesso estruturado às informações
        literárias de forma simples e eficiente.
        </p>

        <button className="home-button" onClick={handleExplorarCatalogo}>
        Explorar Catálogo
        <span className="button-arrow">→</span>
        </button>
    </section>
    </main>
)
}

export default Home