import { Link } from "react-router-dom"
import "../components/Guia.css"

function Guia() {
  return (
    <header className="header">
      <nav className="nav">
        <div className="logoSite">
          Book Cover
        </div>
        <ul className="menu">
          <li><Link to="/">Home</Link></li>
          <li><Link to="/Registro">Registro</Link></li>
          <li><Link to="/Catalogo">Catalogo</Link></li>
        </ul>
      </nav>
    </header>
  )
}

export default Guia