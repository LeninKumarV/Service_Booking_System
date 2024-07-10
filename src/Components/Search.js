import React, { useState,useEffect } from 'react'
import "./Search.css";
import axios from 'axios';

function Search({searchData,setSearchData,searchClick,setSearchClick}) {
    const [search,setSearch]=useState("");
    
    const handleSearch=async (e)=>{
      e.preventDefault();
        const response = await axios.get(`http://localhost:8080/client/clientSearch?serviceName=${search}`)
          .catch((err) => console.log(err));
        setSearchData(response.data);
    }

    const handleInput=async (e)=>{
        setSearch(e.target.value);
        search.toString();
        handleSearch(e);
    }
    useEffect(()=>{
      setSearchClick(search.length===0 ? false : true);
    },[handleInput]);
  return (
    <div className='search'>
        <input type='text' name='search' placeholder='Search here!' onChange={(e)=>handleInput(e)} id='search' />
    </div>
  )
}

export default Search