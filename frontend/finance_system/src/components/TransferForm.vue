<template>
  <div class="flex items-center justify-center min-h-screen w-screen">
    <div class="bg-base-200 p-8 rounded-lg shadow-lg text-center flex flex-col items-center">
      <h1 class="text-3xl font-bold mb-4">Bem-vindo ao sistema de transferências</h1>

      <form @submit.prevent="agendarTransferencia" class="space-y-4 w-96">
        <label class="block">
          <span class="text-gray-700">Conta de Origem</span>
          <input
            v-model="contaOrigem"
            type="text"
            class="input input-bordered w-full mt-1"
            required
          />
        </label>
        <label class="block">
          <span class="text-gray-700">Conta de Destino</span>
          <input
            v-model="contaDestino"
            type="text"
            class="input input-bordered w-full mt-1"
            required
          />
        </label>
        <label class="block">
          <span class="text-gray-700">Data da Transferência</span>
          <input
            v-model="dataTransferencia"
            type="date"
            class="input input-bordered w-full mt-1"
            required
          />
        </label>
        <label class="block">
          <span class="text-gray-700">Valor</span>
          <input
            v-model="valor"
            type="number"
            class="input input-bordered w-full mt-1"
            step="0.01"
            required
          />
        </label>

        <button type="submit" class="btn btn-primary w-full">Agendar Transferência</button>
      </form>

      <p v-if="message" class="mt-4 text-red-500">{{ message }}</p>

      <button
        v-if="!showTransferencias"
        @click="listarTransferencias"
        class="btn btn-secondary mt-6"
      >
        Ver Transferências
      </button>

      <div v-if="transferencias.length > 0" class="mt-6 w-full">
        <h2 class="text-xl font-bold mb-2">Transferências Agendadas</h2>
        <table class="table-auto w-full border-collapse border border-gray-300">
          <thead>
            <tr class="bg-gray-200">
              <th class="border px-4 py-2">Origem</th>
              <th class="border px-4 py-2">Destino</th>
              <th class="border px-4 py-2">Data</th>
              <th class="border px-4 py-2">Valor</th>
              <th class="border px-4 py-2">Taxa</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(transferencia, index) in transferencias" :key="index">
              <td class="border px-4 py-2">{{ transferencia.contaOrigem }}</td>
              <td class="border px-4 py-2">{{ transferencia.contaDestino }}</td>
              <td class="border px-4 py-2">{{ transferencia.dataTransferencia }}</td>
              <td class="border px-4 py-2">{{ transferencia.valor }}</td>
              <td class="border px-4 py-2">{{ transferencia.taxa }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      contaOrigem: '',
      contaDestino: '',
      valor: '',
      dataTransferencia: '',
      message: '',
      transferencias: [],
      showTransferencias: false,
    }
  },
  methods: {
    async agendarTransferencia() {
      const transferencia = {
        contaOrigem: this.contaOrigem,
        contaDestino: this.contaDestino,
        valor: parseFloat(this.valor),
        dataTransferencia: this.dataTransferencia,
      }

      try {
        const response = await fetch('http://localhost:8080/api/transferencias/agendar', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(transferencia),
        })

        const result = await response.text()

        if (!response.ok) {
          this.message = `Erro: ${result}`
        } else {
          this.message = 'Transferência agendada com sucesso!'
          this.limparCampos()
          this.listarTransferencias()
        }
      } catch (error) {
        this.message = 'Erro ao agendar a transferência.'
      }
    },

    async listarTransferencias() {
      try {
        const response = await fetch('http://localhost:8080/api/transferencias')
        this.transferencias = await response.json()
        this.showTransferencias = true
      } catch (error) {
        this.message = 'Erro ao buscar transferências.'
      }
    },

    limparCampos() {
      this.contaOrigem = ''
      this.contaDestino = ''
      this.valor = ''
      this.dataTransferencia = ''
    },
  },
}
</script>
