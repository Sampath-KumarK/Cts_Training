import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import {createBrowserRouter, RouterProvider} from 'react-router-dom'
import './index.css'
import About from './Componennts/About.jsx'
import Contact from './Componennts/Contact.jsx'
import App from './App.jsx'

const  route =createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/about",
    element: <About />,
  },
  {
    path: "/contact",
    element: <Contact />,
  }
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={route} />
  </StrictMode>
)
