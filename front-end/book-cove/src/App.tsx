import { Routes, Route } from "react-router-dom"

import Guia from "./components/Guia.jsx"

import Home     from "./pages/Home/Home.jsx"
import Registro from "./pages/Registro/Registro.jsx"
import Catalago from "./pages/Catalago/Catalago"

function App() {

  return (

    <>
      <Guia />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="/catalogo" element={<Catalago />} />
      </Routes>
    </>
  )

}

export default App