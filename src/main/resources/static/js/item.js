const cart = (shoeId, amount) => {
    fetch(`/cart/${shoeId}/${amount}`)
    .then(resp => resp.json())
    .then(result => {
        console.log(result);        
    });
};

const buy = (shoeId, amount) => {

}

window.postLogin = type => {
    const amount = document.getElementById("amount").value;
    const shoeId = document.querySelector(`.action[data-type='${type}']`).dataset.id;

    alert(`로그인 완료: ${type}`);    

    fetch("/mypage").then(resp => resp.text()).then(result => {
        document.getElementById("nav").innerHTML = result;
    });

    if(type === "cart") {
        cart(shoeId, amount);
    } else if(type === "buy") {
        buy(shoeId, amount);
    }
};

window.addEventListener("load", () => {
    document.querySelectorAll(".action").forEach(item => {
        item.addEventListener("click", e => {
            const { id, login, type } = e.target.dataset;
            const amount = document.getElementById("amount").value;

            alert(`${id} ${type} ${amount} - ${login === "true"}`);  
            
            if(login === "true") {
                if(type === "cart") {
                    cart(id, amount);
                } else if(type === "buy") {
                    buy(id, amount);
                }
            } else {
                const width = 640;
                const height = 480;
                const left = window.screenX + ((window.screen.width - width) / 2);
                const top = window.screenY + ((window.screen.height - height) / 2);
            
                window.open(`/login/${type}/popup`, "login_popup", `left=${left},top=${top},width=${width},height=${height}`);
            }
        });    
    });
});