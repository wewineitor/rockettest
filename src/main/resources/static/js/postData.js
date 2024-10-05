document.getElementById('userForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const initialDate = document.getElementById('initialDate').value;

    const userData = { name, description, initialDate };

    try {
        const response = await fetch('/api/tasks', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userData)
        });

        window.location.href = '/task-list'

    } catch (error) {
        console.error('Error creating user:', error);
    }
});
