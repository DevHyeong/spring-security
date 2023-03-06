import React, {useState, useEffect} from "react";
import axios from "axios";
import { useParams } from "react-router-dom";


const PostsPage = () => {
    
    const [posts, setPosts] = useState([]);
    let params = useParams();

    const getPosts = async () => {
        
        try{
            const response = await axios.get('/post/' + params.name);
            console.log(response);
            setPosts(response.data);
        }catch(e){

        }
    }
    
    useEffect(() => {
        getPosts();
    }, []);
    
    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>순번</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>등록일</th>
                    </tr>
                </thead>
                <tbody>
                {
                    posts.length < 1 && <tr><td colSpan={4}>등록된 게시물이 없습니다.</td></tr>
                }

                {
                    posts.length > 0 && 
                        posts.map(e=> 
                            <tr>
                                <td>{e.id}</td>
                                <td>{e.title}</td>
                                <td>{e.content}</td>
                                <td>{e.createdAt}</td>
                            </tr>
                        
                            )
                }
                </tbody>
            </table>

        </>
    )
}

export default PostsPage;