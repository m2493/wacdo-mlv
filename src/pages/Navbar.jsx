import { NavLink } from "react-router-dom";

function Navbar() {
  const linkStyle = ({ isActive }) => ({
    marginRight: "15px",
    textDecoration: "none",
    color: isActive ? "red" : "black", // lien actif en rouge
  });

  return (
    <nav style={{ padding: "10px", background: "#eee" }}>
      <NavLink to="/" style={linkStyle}>Accueil</NavLink>
      <NavLink to="/collaborator" style={linkStyle}>Collaborateurs</NavLink>
      <NavLink to="/function" style={linkStyle}>Fonctions</NavLink>
      <NavLink to="/restaurant" style={linkStyle}>Restaurants</NavLink>
      <NavLink to="/affectation" style={linkStyle}>Affectations</NavLink>
      
    </nav>
  );
}

export default Navbar;