<template>
  <div class="flex items-center justify-center min-h-screen w-screen">
    <div class="bg-base-200 p-8 rounded-lg shadow-lg text-center flex flex-col items-center">
      <h1 class="text-3xl font-bold mb-4">Bem-vindo ao sistema de transferências</h1>
      <form class="space-y-4 w-screen">
        <label class="block">
          <span class="text-gray-700">Conta de Origem</span>
          <input type="text" class="input input-bordered w-full mt-1" />
        </label>
        <label class="block">
          <span class="text-gray-700">Conta de Destino</span>
          <input type="text" class="input input-bordered w-full mt-1" />
        </label>
        <label class="block">
          <span class="text-gray-700">Conta de Destino</span>
          <input type="date" class="input input-bordered w-full mt-1" />
        </label>
        <label class="block">
          <span class="text-gray-700">Valor</span>
          <input type="number" class="input input-bordered w-full mt-1" />
        </label>
        <button class="btn btn-primary w-full">Agendar Transferência</button>
      </form>
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
}

.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

h1 {
  margin-bottom: 20px;
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px;
  width: 300px;
}

label {
  font-weight: bold;
}

input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 100%;
}
</style>

<script>
export default {
  data() {
    return {
      contaOrigem: '',
      contaDestino: '',
      valor: '',
      dataTransferencia: '',
      message: '',
    }
  },
  methods: {
    async agendarTransferencia() {
      const transferencia = {
        contaOrigem: this.contaOrigem,
        contaDestino: this.contaDestino,
        valor: this.valor,
        dataTransferencia: this.dataTransferencia,
      }

      try {
        const response = await fetch('http://localhost:8080/api/transferencias/agendar', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(transferencia),
        })

        const data = await response.json()
        this.message = data
      } catch (error) {
        this.message = 'Erro ao agendar a transferência'
      }
    },
  },
}
</script>
