import { BrowserRouter,Route,Routes} from "react-router-dom"
import Navigation from "./blueprint/Navigation"
import ListEmployees from "./employees/ListEmployees"
import AddEmployees from "./employees/AddEmployees"
import ModifyEmployees from "./employees/ModifyEmployees"


function App() {
  return (
    <div className="container">
      <BrowserRouter>
        <Navigation/>
        <Routes>
          <Route exact path='/' element={<ListEmployees/>}/>
          <Route exact path='/add' element={<AddEmployees/>}/>
          <Route exact path='/modify/:id' element={<ModifyEmployees/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

