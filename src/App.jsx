import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Restaurant from "./pages/Restaurant/Restaurants";
import RestaurantDetail from "./pages/Restaurant/RestaurantDetail";
import CreateRestaurantPage from "./pages/Restaurant/CreateRestaurantPage";
import Affectation from "./pages/Affectations";
import Collaborator from "./pages/Collaborators";
import Navbar from "./pages/Navbar";
import Function from "./pages/Functions";

function App() {
  return (
    <Router>
      <Navbar />

      <Routes>
        <Route path="/collaborator" element={<Collaborator />} />
        <Route path="/restaurant" element={<Restaurant />} />
        <Route path="/restaurants/:id" element={<RestaurantDetail />} />
        <Route path="/function" element={<Function />} />
        <Route path="/affectation" element={<Affectation />} />
        <Route path="/restaurants/create" element={<CreateRestaurantPage />} />
      </Routes>
    </Router>
  );
}

export default App;