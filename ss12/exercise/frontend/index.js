function renderBlogs(blogs,append){
    let element = "";
    for (let blog of blogs){
        element += `
            <div class="card col-sm-3">
                <div class="card-body">
                <h5 class="card-title">${blog.nameBlog}</h5>
                <p class="card-text">${blog.contentBlog}</p>
                <p class="card-text">${blog.authorBlog}</p>
                <a href="#" class="btn btn-primary">Read more</a>
                </div>
            </div>
        `
    }
    if (append){
        $("#listBlog").append(element);
    } else $("#listBlog").html(element);
}

function loadMore(nextPage){
    loadBlogs(nextPage,true);
}

function renderLoadMoreButton(blogPageData){
    if (blogPageData.number < blogPageData.totalPages-1){
        $("#loadMoreButton").html(
            `
            <button type="button" class="btn btn-secondary" onclick="loadMore(${blogPageData.number +1})">
                Load More
            </button>
            `
        );
    } else $("#loadMoreButton").remove();
}

function loadBlogs(page, append){
    let keySearch = document.getElementById("search").value;
    $.ajax({
        type:"GET",
        url:`http://localhost:8080/api/blog?page=${page ? page : "0"}&search=` + keySearch ,
        Headers:{
            "Content-Type":"application/json",
        },
        success: (data) => {
            renderBlogs(data.content,append),
            renderLoadMoreButton(data)
        },
        error: function(error){
            console.log(error);
        }
    });
}

$(document).ready(() => loadBlogs());