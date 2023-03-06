import React from 'react';
import { Routes, Route } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Login from './page/Login';
import Join from './page/Join';
import PostsPage from './page/post/PostsPage';
import PostCreatePage from './page/post/PostCreatePage';

const App = () => {

    return (
     
      <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/join" element={<Join/>}/>
          <Route path="/post/:name" element={<PostsPage/>}>
            <Route path=":name" element={<PostsPage/>} />
          </Route>
          <Route path="/post/create" element={ <PostCreatePage/>} />
      </Routes>
      
    )



}

export default App;
