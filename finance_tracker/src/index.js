import React from 'react';
import ReactDOM from 'react-dom';


import HelpPage from "./pages/HelpPage";
import EnterData from "./pages/EnterData";
import DisplayData from "./pages/DisplayData";
import App from "./App";


import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
    },
    {
        path: "Enter",
        element: <EnterData />,
    },
    {
        path: "Help",
        element: <HelpPage />,
    },
    {
        path: "Display",
        element: <DisplayData />,
    },
]);
ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
      <RouterProvider router={router} />
    </React.StrictMode>
);    
