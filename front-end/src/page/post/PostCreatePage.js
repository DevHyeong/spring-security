import React from "react";
import axios from "axios";

const PostCreatePage = () => {

    const create = () => {
        const title = document.querySelector('input[name=title]').value;
        const content = document.querySelector('textarea[name=content]').value;
        const role = document.querySelector('select[name=role]').value;

        try{
            const response = axios.post("/post/create", {
                title : title,
                content : content,
                role : role
            });

        }catch(e){

        }
    }


    return (
        <>
            <div>
                <span>제목</span>
                <input type="text" name="title"/>
            </div>
            <div>
                <span>내용</span>
                <textarea name="content" />
            </div>
            <div>
                <span>게시판 권한</span>
                <select name="role">
                    <option value="NORMAL">NORMAL</option>
                </select>
            </div>
            <button onClick={create}>등록</button>

        </>
    )

}

export default PostCreatePage;