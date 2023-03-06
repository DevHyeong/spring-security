import React from "react";
import axios from "axios";
import { Buffer } from "buffer";



const Login = () =>{

    const login = async () => {

        const userid = document.querySelector('input[name=userid').value;
        const password = document.querySelector('input[name=password]').value;

        const headers = {
            'Content-Type' : 'application/json',
            'Authorization' : 'Basic ' + Buffer.from(`${userid}:${password}`).toString('Base64')
        }

        try{
            const response = await axios.post("/user/auth", {}, {
                headers: headers
            });

            if(response.status == 200){
                window.location.href = "/post/" + response.data.username;
            }
            
        }catch(e){

        }


    }



    return (
        <div>
            <div>
                <span>아이디 입력</span>
                <input name="userid" />
            </div>
            <div>
                <span>비밀번호 입력</span>
                <input name="password" />
            </div>
            <button onClick={login}>로그인</button>
        </div>
    )

}

export default Login;