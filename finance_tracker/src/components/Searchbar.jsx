import React from "react";
import { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function Searchbar() {
    const [isChatOpen, setChatOpen] = useState(false);
    const [messages, setMessagesAndColour] = useState([
        { text: "Hi! I'm your financial tracker virtual assistant.", sender: "received" }
    ]);
    const [newMessage, setNewMessageText] = useState("")
    const openChat = () => setChatOpen(true);
    const closeChat = () => setChatOpen(false);
    const handleSendMessage = () => {
        const updatedMessages = [...messages, { text: newMessage, sender: "sent" }];
        setMessagesAndColour(updatedMessages);
        setNewMessageText("");  
        setTimeout(() => {
            setMessagesAndColour([...updatedMessages, { text: "Got it! We'll get back to you on this", sender: "received" }]);
        }, 1000);      
    };
    return (
        <div className="page2-header">
            {isChatOpen && (
                <div className="chat-box ">
                    <div className="chat-header">
                        <span className="chat-title">Customer Support</span>
                        <button onClick={closeChat} className="close-chat">X</button>
                    </div>
                    <div className="chat-content">
                        {messages.map((message, index) => (
                            <div key={index} className={`message ${message.sender}`}>
                                <p>{message.text}</p>
                            </div>
                        ))}
                    </div>
                    <div className="chat-footer">
                        <input type="text"  placeholder="Type a message here..." className="chat-input" value={newMessage} onChange={(e) => setNewMessageText(e.target.value)}/>
                        <button onClick={handleSendMessage} className="send-button">Send</button>
                    </div>
                </div>
            )}

            <h1 className="page2-h1">Hi! how can we help?</h1>
            <input className="search" placeholder="Enter a forum enquiry here!" aria-label="Search bar to look for forum posts"/>  
            <svg className="search-button" viewBox="0 0 16 16" height="32" width="32" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlnsXlink="http://www.w3.org/1999/xlink" fill="#000000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <rect width="16" height="16" id="icon-bound" fill="none"></rect> <path d="M15.708,13.587l-3.675-3.675C12.646,8.92,13,7.751,13,6.5C13,2.91,10.09,0,6.5,0S0,2.91,0,6.5S2.91,13,6.5,13 c1.251,0,2.42-0.354,3.412-0.967l3.675,3.675c0.389,0.389,1.025,0.389,1.414,0l0.707-0.707 C16.097,14.612,16.097,13.976,15.708,13.587z M3.318,9.682C2.468,8.832,2,7.702,2,6.5s0.468-2.332,1.318-3.182S5.298,2,6.5,2 s2.332,0.468,3.182,1.318C10.532,4.168,11,5.298,11,6.5s-0.468,2.332-1.318,3.182C8.832,10.532,7.702,11,6.5,11 S4.168,10.532,3.318,9.682z"></path> </g></svg>

            <div className="page2-row">
                <div className="col-sm-4" style={{ maxWidth: "25rem", padding: "0 10px" }}>
                    <div className="card page2-card">
                        <div className="card-body page2-body">
                            <h2 className="card-title page2-title">Start a live chat</h2>
                            <p className="card-text page2-text">Our assistants on board are able to deal efficiently with any problems.</p>
                            <button onClick={openChat} className="btn btn-secondary page2-button">Live chat</button>    
                        </div>
                    </div>
                </div>
                <div className="col-sm-4" style={{ maxWidth: "25rem", padding: "0 10px" }}>
                    <div className="card page2-card">
                        <div className="card-body page2-body">
                            <h2 className="card-title page2-title">Check out the forum</h2>
                            <p className="card-text page2-text">We have almost 1000 forum posts; feel free to post a question.</p>
                            <a href="#" className="btn btn-secondary page2-button">Forum</a>
                        </div>
                    </div>
                </div>
                <div className="col-sm-4" style={{ maxWidth: "25rem", padding: "0 10px" }}>
                    <div className="card page2-card">
                        <div className="card-body page2-body">
                            <h2 className="card-title page2-title">General questions</h2>
                            <p className="card-text page2-text">Before contacting us, please check if your inquiry has been answered here.</p>
                            <a href="#" className="btn btn-secondary page2-button">FAQ</a>
                        </div>
                    </div>
                </div>
            </div>

            <div className="contact">
                <h3 className="page2-h3">Contact Information</h3>
                <p>Email: FinancialTrackerhelp@gmail.com</p>
                <p>Phone: +44988436078</p>
                <p>Twitter @FinancialServicesUK</p>
                <p>Facebook @FinancialServicesUK</p>
            </div>
        </div>
    );
}

export default Searchbar