document.addEventListener('DOMContentLoaded', () => {
    getData();
});

const getData = async () => {
    try {
        const userTableBody = document.getElementById('userTableBody')
        userTableBody.innerHTML = ``;

        const response = await fetch('/api/tasks')
        const data = await response.json()


        data.forEach(element => {
            const row = `
            <tr>
            <td>${element.name}</td>
            <td>${element.description}</td>
            <td>${element.initialDate}</td>
            <td>
                <button class="btn btn-sm btn-danger" onclick="deleteUser(${element.id})">Eliminar</button>
            </td>
        </tr>
        `
            userTableBody.innerHTML += row;
        });
    } catch (error) {
        console.error('Error fetching users:', error)
    }
}

async function deleteUser(id) {
    try {
        const response = await fetch(`/api/tasks/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            await getData();
        } else {
            console.error('Error deleting user:', response.statusText);
        }
    } catch (error) {
        console.error('Error deleting user:', error);
    }
}