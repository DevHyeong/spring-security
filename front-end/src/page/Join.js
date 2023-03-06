import React from "react";
import axios from "axios";

const Join = () =>{
    
    const join = () => {
        const email = document.querySelector('input[name=email]').value;
        const password = document.querySelector('input[name=password]').value;
        const nickname = document.querySelector('input[name=nickname]').value;

        try{

            const response = axios.post('/user/join', {
                email : email,
                password : password,
                nickname : nickname
            });

        }catch(e){

        }
    }

    return (
        <>
            <div>
                <div>
                    <span>이메일 입력(아이디)</span>
                    <input name="email"/>
                </div>
                <div>
                    <span>비밀번호</span>
                    <input name="password"/>
                </div>
                <div>
                    <span>닉네임</span>
                    <input name="nickname"/>
                </div>
                <button onClick={join}>회원가입</button>

            </div>
        
        </>
    )
}

export default Join;