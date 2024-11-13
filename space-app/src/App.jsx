import {styled} from "styled-components"
import GlobalStyles from "./components/GlobalStyles"
import Header from "./components/Cabecalho"
import Sidebar from "./components/Sidebar"
import Banner from "./components/Banner"

const GradientBackground = styled.div`
  background: linear-gradient(174.61deg, #041833 4.16%, #04244F 48%,  #154580 96.76%);
  width: 100vw;
  min-height:100vh;
`                                             

function App() {
  return (
    <GradientBackground>
      <GlobalStyles/>
      <Header/>    
      <Sidebar/> 
      <Banner/>

    </GradientBackground>
  )
}

export default App
