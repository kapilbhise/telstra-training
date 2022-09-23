import { Backdrop } from "./components/Backdrop";
import { Box } from "./components/Box";
import { Modal } from "./components/Modal";
function App() {
  return (
    <div className='App'>
      <h1 style={{ marginLeft: "10px" }}>My Box app</h1>
      <Box number='1' />
      <Box number='2' />
      <Box number='3' />
    </div>
  );
}

export default App;
